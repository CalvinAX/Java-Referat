<template>
    <div class="login-wrapper">
        <section>
            <div class="heading">
                <span>Jira</span>
                <div>
                    <h5 v-if="loggedIn">You're already logged in!</h5>
                    <h5 v-else>Einloggen, um fortzufahren</h5>
                </div>
            </div>
            <div v-if="loggedIn" class="back">
                <button @click="handleSignOut()">Logout</button>
                <NuxtLink :to="'/'">Home</NuxtLink>
            </div>
            <form v-else @submit.prevent="signIn('credentials', { email, password, callbackUrl: '/tickets' })">
                <div :class="{ 'focused': isFocusedEmail }">
                    <input type="email" v-model="email" name="emailInput" id="emailInput" placeholder="E-Mail-Adresse"
                        @focus="changeBorderColorEmail(true)" @blur="changeBorderColorEmail(false)">
                </div>
                <div :class="{ 'focused': isFocusedPassword }">
                    <input v-model="password" type="password" name="passwordInput" id="passwordInput" placeholder="Password"
                        @focus="changeBorderColorPassword(true)" @blur="changeBorderColorPassword(false)">
                </div>
                <button>Login</button>
            </form>
        </section>
    </div>
</template>

<script setup lange="ts">
definePageMeta({
    layout: 'login'
})

const email = ref('');
const password = ref('');

//const emailValidation = useEmailValidation(email);

// const localePath = useLocalePath();

const { status, signIn, signOut } = useAuth();

const loggedIn = computed(() => status.value === 'authenticated');

const handleSignOut = async () => {
    await signOut();
}

const isFocusedEmail = ref(false)
const isFocusedPassword = ref(false)
const changeBorderColorEmail = (focus) => {
    isFocusedEmail.value = focus
}
const changeBorderColorPassword = (focus) => {
    isFocusedPassword.value = focus
}

</script>

<style lang="scss">
@import "@/assets/scss/variables.scss";

.login-wrapper {
    display: grid;
    place-content: center;
    height: 100vh;

    button {
        height: 40px !important;
        line-height: 40px !important;

        -moz-box-align: baseline;
        align-items: baseline;
        border-width: 0px;
        border-radius: 3px;
        box-sizing: border-box;
        display: inline-flex;
        font-size: inherit;
        font-style: normal;
        font-family: inherit;
        font-weight: 500;
        max-width: 100%;
        position: relative;
        text-align: center;
        text-decoration: none;
        transition: background 0.1s ease-out 0s, box-shadow 0.15s cubic-bezier(0.47, 0.03, 0.49, 1.38) 0s;
        white-space: nowrap;
        background: #0052CC;
        color: #FFFFFF !important;
        cursor: pointer;
        height: 2.28571em;
        line-height: 2.28571em;
        padding: 0px 10px;
        vertical-align: middle;
        width: 100%;
        -moz-box-pack: center;
        justify-content: center;

        &:active {
            background-color: #B6C2CF;

            // #458d7c;
            // $font-color: #B6C2CF; // #fff
            // $bg-button: #618c7c;
        }
    }

    .back {
        display: flex;
        flex-direction: column;
        align-items: center;

        a {
            text-decoration: none;
            margin-top: 15px;

            &:active {
                color: black;
            }
        }
    }

    section {
        display: flex;
        flex-direction: column;
        // margin: 0px auto;
        width: 400px;
        padding: 50px 40px;
        background: rgb(255, 255, 255);
        border-radius: 3px;
        box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 10px;
        box-sizing: border-box;
        color: rgb(94, 108, 132);

        .heading {
            display: flex;
            flex-direction: column;
            -moz-box-align: center;
            align-items: center;
            text-align: center;
            margin-bottom: 40px;

            span {
                font-weight: 500;
                font-size: 30px;
                line-height: 20px;
                color: rgb(23, 43, 77);
            }

            div {
                display: flex;
                flex-direction: column;
                padding-top: 24px;
                -moz-box-align: center;
                align-items: center;

                h5 {
                    font-weight: 600;
                    font-size: 16px;
                    line-height: 20px;
                    color: rgb(23, 43, 77);
                }
            }
        }

        form {
            .focused {
                border-color: #2684ff;
            }

            div {
                margin-bottom: 10px;

                -moz-box-align: center;
                align-items: center;
                background-color: #FAFBFC;
                border-color: #DFE1E6;
                color: #091E42;
                cursor: text;
                border-radius: 3px;
                border-width: 2px;
                border-style: solid;
                box-sizing: border-box;
                display: flex;
                flex: 1 1 100%;
                font-size: 14px;
                -moz-box-pack: justify;
                justify-content: space-between;
                max-width: 100%;
                overflow: hidden;
                transition: background-color 0.2s ease-in-out 0s, border-color 0.2s ease-in-out 0s;
                overflow-wrap: break-word;
                vertical-align: top;
                pointer-events: auto;

                input {
                    background-color: transparent;
                    border: 0px;
                    box-sizing: border-box;
                    color: inherit;
                    cursor: inherit;
                    font-size: 14px;
                    min-width: 0px;
                    outline: none;
                    width: 100%;
                    line-height: 1.42857;
                    font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", "Roboto", "Oxygen", "Ubuntu", "Fira Sans", "Droid Sans", "Helvetica Neue", sans-serif;

                    padding: 8px 6px;
                    height: 2.57em;
                }

                &:nth-child(2) {
                    margin-bottom: 24px;
                }
            }

            // button {
            //     height: 40px !important;
            //     line-height: 40px !important;

            //     -moz-box-align: baseline;
            //     align-items: baseline;
            //     border-width: 0px;
            //     border-radius: 3px;
            //     box-sizing: border-box;
            //     display: inline-flex;
            //     font-size: inherit;
            //     font-style: normal;
            //     font-family: inherit;
            //     font-weight: 500;
            //     max-width: 100%;
            //     position: relative;
            //     text-align: center;
            //     text-decoration: none;
            //     transition: background 0.1s ease-out 0s, box-shadow 0.15s cubic-bezier(0.47, 0.03, 0.49, 1.38) 0s;
            //     white-space: nowrap;
            //     background: $solid-color; // #0052CC;
            //     color: #FFFFFF !important;
            //     cursor: pointer;
            //     height: 2.28571em;
            //     line-height: 2.28571em;
            //     padding: 0px 10px;
            //     vertical-align: middle;
            //     width: 100%;
            //     -moz-box-pack: center;
            //     justify-content: center;
            // }
        }
    }
}


// .login-site-wrapper {
//     height: 100vh;
//     width: 100%;
//     display: flex;
//     justify-content: center;
//     align-items: center;
//     background-color: #1a1f26;
// }

// .login-form-wrapper {
//     background-color: #14191f;
//     // color: #f9fafb;
//     color: #f9fafb;
//     padding: 24px;
//     border-radius: 12px;
// }

// .login-form-item {
//     margin: 16px 0;
// }

// .login-form-label {
//     display: block;
//     margin-bottom: 8px;
// }

// .login-form-input {
//     width: 320px;
//     padding: 8px;
//     background-color: #1f262e;
//     color: #9ca3af;
//     border: none;
//     border-radius: 8px;
// }


// .login-form-btn {
//     background-color: #29333d; 
//     padding: 8px 16px;
//     border: 1px solid #1f262e;
//     border-radius: 8px;
//     box-shadow: rgba(0, 0, 0, 0.15) 1.95px 1.95px 2.6px;
//     color: #f9fafb;

//     &:hover {
//         cursor: pointer;
//         background-color: #47596b;
//         transition: ease-in-out 0.2s;
//     }
// }
</style>