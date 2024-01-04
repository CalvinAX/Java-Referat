<template>
    <div class="default-automat-ui">
        <Header @toggle="showSidebar = !showSidebar" />
        <div class="main">
            <!-- <div v-if="showSidebar" class="sidebar"> -->
            <Sidebarr v-if="showSidebar" class="sidebar" />
            <!-- </div> -->
            <div class="content" @click="showSidebar = false">
                <slot />

            </div>
        </div>
        <div class="footer">
            <Footer />
        </div>
    </div>
</template>

<script setup lang="ts">
// const props = defineProps(['pageTitle'])
const showSidebar = ref(true)
</script>

<style lang="scss">
@import "@/assets/scss/variables.scss";

.default-automat-ui {
    display: flex;
    flex-direction: column;
    min-height: 100vh;

    .sidebar {
        .toggle-sidebar {
            font: inherit;
            // background: $bg-button;
            color: white;
            padding: 8px 16px;
            border: none;
            cursor: pointer;
            border-radius: 5px;
            font-weight: 400;
            margin-left: 50%;
            // margin-right: auto;
        }
    }

    .main {
        display: grid;
        // grid-template-columns: fit-content(20ch) minmax(min(50vw, 30ch), 1fr);
        // grid-template-areas:
        //     'sidebar content'
        // ;
        grid-template-areas: "stack";

        .sidebar {
            // grid-area: sidebar;
            grid-area: stack;
            max-width: 70%;
            min-width: 280px;
            z-index: 3;
        }

        .content {
            // grid-area: content;
            grid-area: stack;
        }
    }



    // .footer {
    //     margin-top: auto;
    //   }
}
</style>