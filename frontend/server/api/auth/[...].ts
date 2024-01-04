import { NuxtAuthHandler } from '#auth';
import CredentialsProvider from 'next-auth/providers/credentials';

const config = useRuntimeConfig()

export default NuxtAuthHandler({
    secret: config.authSecret,
    pages: {
        // Set /login as default login page
        signIn: '/login'
    },
    callbacks: {
        jwt: async ({ token, user }) => {
            const isSignIn = user ? true : false;
            if (isSignIn) {
                token.username = user ? (user as any).username || '' : '';
                token.cookieAuth = user ? (user as any).cookieAuth || '' : '';
                token.cookieJWT = user ? (user as any).cookieJWT || '' : '';
            }
            return Promise.resolve(token);
        },
        session: async ({ session, token }) => {
            (session as any).username = token.username;
            return Promise.resolve(session);
        },
    },
    events: {
        signIn: async () => {
            // Handle sign-in event
            console.log('User signed in:');
        },
        signOut: async (token) => {
            // Handle sign-out event
            const cookieAuth: CookieObject = token.token.cookieAuth as CookieObject;
            const cookieJWT: CookieObject = token.token.cookieJWT as CookieObject;
            let authCookie
            let jwtCookie

            if (!isExpired(cookieAuth.expires)) {
                 authCookie = `${cookieAuth.name}=${cookieAuth.value}; Path=${cookieAuth.path}; Domain=${cookieAuth.domain}; Expires=${cookieAuth.expires}; Max-Age=${cookieAuth.maxAge}; HttpOnly`;
            }
            if (!isExpired(cookieJWT.expires)) {
                 jwtCookie = `${cookieJWT.name}=${cookieJWT.value}; Path=${cookieJWT.path}; Domain=${cookieJWT.domain}; Max-Age=${cookieJWT.maxAge}; HttpOnly`;
            }

            try {
                const response = await fetch('http://localhost:8080/auth/logout', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                        'Cookie': `${authCookie}; ${jwtCookie}`
                    }
                });
                const data = await response.json();

                if (data.error) {
                    throw new Error(data.error);
                }
                console.log(data.msg);
                // console.log('User signed out');
                // Handle response from the authentication server
                // You might want to check for success and send an appropriate response
            } catch (error) {
                console.error('Error during logout:', error);
            }

        },
    },
    providers: [
        // @ts-expect-error You need to use .default here for it to work during SSR. May be fixed via Vite at some point
        CredentialsProvider.default({
            name: 'Credentials',
            async authorize(credentials: any) {

                const response = await fetch('http://localhost:8080/auth/login', {
                    method: 'post',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify({
                        email: credentials.email,
                        password: credentials.password,
                    }),
                    credentials: 'include',
                })

                if (response.ok) {
                    const data = await response.json(); // Extrahiere JSON-Daten aus der Antwort
                    if (!data) {
                        return;
                    }

                    let authCookieValue: CookieObject | null = null
                    let jwtCookieValue: CookieObject | null = null
                    // Überprüfe, ob Cookies im Header vorhanden sind
                    if (response.headers.has('Set-Cookie')) {
                        const cookies = response.headers.get('Set-Cookie');
                        console.log('Erhaltene Cookies:', cookies);

                        authCookieValue = getCookieValue(cookies || "", 'auth');
                        if (authCookieValue === null) {
                            console.error('cookie not found');
                        }

                        jwtCookieValue = getCookieValue(cookies || "", 'jwt');
                        if (jwtCookieValue === null) {
                            console.error('cookie not found');
                        }
                    }

                    if (data) {
                        let userData: any = response;

                        const user = {
                            // 'email': userData.email,
                            'username': userData.username,
                            'cookieAuth': authCookieValue,
                            'cookieJWT': jwtCookieValue,
                            // 'id': userData.id,
                            // 'jwt': userData.jwt,
                        }

                        return user;
                    }
                    console.log('successfully logged in');
                } else {
                    // Handle Fehlerfälle hier
                    console.error('Feherror during login:', response.statusText);
                }
            }
        })
    ]
})

interface CookieObject {
    name: string;
    value: string;
    path: string;
    domain: string;
    expires: string;
    maxAge: string;
}

function getCookieValue(cookieString: string, cookieName: string): CookieObject | null {
    // reset object values
    let cookieObject: CookieObject = {
        name: '',
        value: '',
        path: '',
        domain: '',
        expires: '',
        maxAge: ''
    };

    // get single cookie
    const cookies = cookieString.split('y, '); // maybe find a better way
    // range cookies
    for (const cookie of cookies) {
        // get all cookie parts
        const cookieParts = cookie.split('; ');
        // range all cookie parts
        for (const cookiePart of cookieParts) {
            // get single cookie part
            const [key, value] = cookiePart.split('=');
            // check if it is the requestet cookie (cookieName)
            if (key === cookieName) {
                cookieObject.name = key;
                cookieObject.value = value;
            } else if (key === 'Path') {
                cookieObject.path = value;
            } else if (key === 'Domain') {
                cookieObject.domain = value;
            } else if (key === 'Expires') {
                cookieObject.expires = value;
            } else if (key === 'Max-Age') {
                cookieObject.maxAge = value;
                if (cookieObject.expires === '') {
                    // cookieObject.expires = formatCookieExpiration(parseInt(value))
                    cookieObject.expires = getExpirationDate(parseInt(value))
                }
            }

            if (cookieObject.name !== cookieName) {
                break
            }
        }

        if (cookieObject.name !== '') {
            return cookieObject
        }

    }

    return null;
}

// converts seconds to expiration date in GMT format
function getExpirationDate(seconds: number) {
    const currentDate = new Date();
    const expirationDate = new Date(currentDate.getTime() + seconds * 1000);
    return expirationDate.toUTCString();
}

// checks if date is expired
function isExpired(expirationDate: string) {
    const currentGMTDate = new Date().toUTCString();
    return new Date(expirationDate) <= new Date(currentGMTDate);
}

// const isExpired = (expirationDate: string) => {
//     const currentGMTDate = new Date().toUTCString();
//     return new Date(expirationDate) <= new Date(currentGMTDate);
// }