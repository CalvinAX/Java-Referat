<template>
    <div class="site-wrapper">
        <Sidebar />
        <main class="main-content">
            <slot />
        </main>

    </div>
</template>

<style lang="scss">
@import "@/assets/scss/variables.scss";

.site-wrapper {
    display: flex;
}

.main-content {
    width: 100%;
    background-color: $bg-dark-400;
    color: $text-white-100;
}
</style>