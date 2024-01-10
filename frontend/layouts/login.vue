<template>
    <div class="login-automat-ui">
        <!-- <Header @toggle="showSidebar = !showSidebar" /> -->
        <div class="login-main">
            <!-- <div v-if="showSidebar" class="sidebar"> -->
            <!-- <Sidebarrr class="sidebar" :class="{ close: !showSidebar }" /> -->
            <!-- v-if="showSidebar" class="sidebar" :class="{hidden: 'showSidebar == true'}"-->
            <!-- </div> -->
            <div class="content"> <!-- @click="showSidebar = false" -->
                <slot />

            </div>
        </div>
    </div>
</template>

<script setup lang="ts">
</script>

<style lang="scss">
@import "@/assets/scss/variables.scss";

.login-automat-ui {
    .login-main {
        overflow: hidden;
        flex: 1;

        .content {
            flex: 1;
            position: relative;
            left: 0;
            max-width: calc(100% - $sidebar-width);
            transition: $trans-05;
        }

    }
}
</style>