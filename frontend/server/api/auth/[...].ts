import { NuxtAuthHandler } from '#auth';
import CredentialsProvider from 'next-auth/providers/credentials';

export default NuxtAuthHandler({
    pages: {
        // Set /login as default login page
        signIn: '/login'
    },
    callbacks: {
        jwt: async ({ token, user }) => {
            const isSignIn = user ? true : false;
            if (isSignIn) {
                token.id = user ? (user as any).id || '' : '';
                token.jwt = user ? (user as any).jwt || '' : '';
            }
            return Promise.resolve(token);
        },
        session: async ({ session, token }) => {  
            (session as any).id = token.id;
            (session as any).jwt = token.jwt;
            return Promise.resolve(session); 
        },
    },
    providers: [
        // @ts-expect-error You need to use .default here for it to work during SSR. May be fixed via Vite at some point
        CredentialsProvider.default({
            name: 'Credentials',
            async authorize(credentials: any) {

                const data = await $fetch('http://localhost:8001/auth/login', {
                    method: 'post',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    body: {
                        email: credentials.email,
                        password: credentials.password,
                    }
                })

                if (!data) {
                    return;
                }

                if (data) {
                    let userData: any = data;

                    const user = {
                        'email': userData.email,
                        'username': userData.username,
                        'id': userData.id,
                        'jwt': userData.jwt,
                    }

                    return user;
                }
            }
        })
    ]
})
