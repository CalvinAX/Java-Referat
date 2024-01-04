<template>
    <div class="topbar-wrapper">
        <input type="text" placeholder="Search..." class="topbar-searchbar"/>
    </div>
</template>

<script setup>

</script>

<style lang="scss">
@import "@/assets/scss/variables.scss";

.topbar-wrapper {
    width: 100%;
    background-color: $bg-dark-200;
    display: flex;
    justify-content: center;
    align-items: center;
    padding: 16px;
    border-bottom: 1px solid $bg-dark-300;
}

.topbar-searchbar {
    width: clamp(500px, 600px, 700px);
    padding: 8px;
    border-radius: 8px;
}
</style>