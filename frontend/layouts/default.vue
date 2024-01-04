<template>
    <div class="default-automat-ui">
        <Header @toggle="showSidebar = !showSidebar" />
        <div class="main">
            <!-- <div v-if="showSidebar" class="sidebar"> -->
            <Sidebarrr class="sidebar" :class="{ close: !showSidebar }" />
            <!-- v-if="showSidebar" class="sidebar" :class="{hidden: 'showSidebar == true'}"-->
            <!-- </div> -->
            <div class="content"> <!-- @click="showSidebar = false" -->
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

    .main {
        overflow: auto;
        flex: 1;
        display: flex;

        .sidebar {
            position: fixed;
            top: 56px;
            left: 0;
            height: calc(100% - $header-height);
            width: $sidebar-width;
            z-index: 3;
            transition: $trans-05;

            &.close {
                width: $sidebar-width-closed;
            }

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
            }
        }

        .content {
            flex: 1;
            position: relative;
            left: $sidebar-width;
            max-width: calc(100% - $sidebar-width);
            transition: $trans-05;
        }

        .sidebar.close~.content {
            flex: 1;
            left: $sidebar-width-closed;
            max-width: calc(100% - $sidebar-width-closed);
        }
    }



    // .footer {
    //     margin-top: auto;
    //   }
}
</style>