<template>
    <div class="login-site-wrapper">
        <div class="login-form-wrapper">
            <div v-if="loggedIn">
                <p>You're already logged in!</p>
                <div style="display: flex;">
                    <button @click="handleSignOut()" class="login-form-btn">{{ $t('logout') }}</button>
                    <button class="login-form-btn" style="margin-left: 12px;">
                        <NuxtLink :to="localePath('/')" style="color: white; text-decoration: none;">Home</NuxtLink>
                    </button>
                </div>

            </div>
            <form v-else>
                <div class="login-form-item">
                    <label for="emailInput" class="login-form-label">Email:</label>
                    <input v-model="email" type="email" name="emailInput" id="emailInput" placeholder="Email"
                        class="login-form-input">
                </div>
                <div class="login-form-item">
                    <label for="passwordInput" class="login-form-label">Password:</label>
                    <input v-model="password" type="password" name="passwordInput" id="passwordInput" placeholder="Password"
                        class="login-form-input">
                </div>
                <div class="login-form-item">
                    <button class="login-form-btn"
                        @click.prevent="signIn('credentials', { email, password, callbackUrl: '/' })">{{ $t('login')
                        }}</button>
                </div>
            </form>
        </div>
    </div>
</template>

<script setup lange="ts">

const email = ref('');
const password = ref('');

//const emailValidation = useEmailValidation(email);

const localePath = useLocalePath();

const { status, signIn, signOut } = useAuth();

const loggedIn = computed(() => status.value === 'authenticated');

async function handleSignOut() {
    await signOut();
}

</script>

<style lang="scss">
@import "@/assets/scss/variables.scss";

.login-site-wrapper {
    height: 100vh;
    width: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
    background-color: $bg-dark-100;
}

.login-form-wrapper {
    background-color: $bg-dark-200;
    color: $text-white-100;
    padding: 24px;
    border-radius: 12px;
}

.login-form-item {
    margin: 16px 0;
}

.login-form-label {
    display: block;
    margin-bottom: 8px;
}

.login-form-input {
    width: 320px;
    padding: 8px;
    background-color: $bg-dark-300;
    color: $text-white-200;
    border: none;
    border-radius: 8px;
}


.login-form-btn {
    background-color: $btn-dark-100;
    padding: 8px 16px;
    border: 1px solid $bg-dark-300;
    border-radius: 8px;
    box-shadow: rgba(0, 0, 0, 0.15) 1.95px 1.95px 2.6px;
    color: $text-white-100;

    &:hover {
        cursor: pointer;
        background-color: $text-white-300;
        transition: ease-in-out 0.2s;
    }
}
</style>