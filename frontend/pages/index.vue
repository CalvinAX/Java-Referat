<template>
    <div class="home-wrapper">
        <Topbar />
        <h1>Open Page - Everyone</h1>
        <button class="test-button" v-if="loggedIn" @click="handleSignOut">Sign Out</button>
        <button class="test-button" v-else @click="handleSignIn">Sign In</button>
    </div>
</template>

<script setup lange="ts">
definePageMeta({ middleware: 'auth' })

const { status, signIn, signOut } = useAuth();

const loggedIn = computed(() => status.value === 'authenticated');

async function handleSignIn() {
    await signIn();
}

async function handleSignOut() {
    await signOut();
}

definePageMeta({
    layout: 'sidebar',
})

</script>

<style lang="scss">
@import "@/assets/scss/variables.scss";
.test-button {
    background-color: $btn-dark-100;
    padding: 8px 16px;
    border: 1px solid $border-color-100;
    border-radius: 8px;
    box-shadow: rgba(0, 0, 0, 0.15) 1.95px 1.95px 2.6px;
    color: $text-white-100;
}
</style>