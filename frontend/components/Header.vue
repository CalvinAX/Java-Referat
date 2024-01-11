

<template>
    <div class="comp-header">
        <header>
            <div class="burger" @click="emitToggleEvent">
                <!-- <img src="@/assets/img/icons/burger-menu.svg" alt="Menu"> -->
                <svg xmlns="http://www.w3.org/2000/svg" height="30" width="28" fill="white" viewBox="0 0 448 512">
                    <path
                        d="M0 96C0 78.3 14.3 64 32 64H416c17.7 0 32 14.3 32 32s-14.3 32-32 32H32C14.3 128 0 113.7 0 96zM0 256c0-17.7 14.3-32 32-32H416c17.7 0 32 14.3 32 32s-14.3 32-32 32H32c-17.7 0-32-14.3-32-32zM448 416c0 17.7-14.3 32-32 32H32c-17.7 0-32-14.3-32-32s14.3-32 32-32H416c17.7 0 32 14.3 32 32z" />
                </svg>
                <!-- <svg height="20px" width="20px" version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg"
                    xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 185.343 185.343" xml:space="preserve">
                    <g>
                        <g>
                            <path style="fill:#010002;" d="M51.707,185.343c-2.741,0-5.493-1.044-7.593-3.149c-4.194-4.194-4.194-10.981,0-15.175
			l74.352-74.347L44.114,18.32c-4.194-4.194-4.194-10.987,0-15.175c4.194-4.194,10.987-4.194,15.18,0l81.934,81.934
			c4.194,4.194,4.194,10.987,0,15.175l-81.934,81.939C57.201,184.293,54.454,185.343,51.707,185.343z" />
                        </g>
                    </g>
                </svg> -->
            </div>
            <div class="logo">
                <!-- <NuxtLink to="/">
                    <img src="@/assets/img/sc_logo.png" alt="Logo">
                </NuxtLink> -->
            </div>
            <!-- <button id="signout" @click="">Sign out</button> -->
        </header>
    </div>
</template>
  
<script setup lang="ts">
const emit = defineEmits(['toggle'])

const emitToggleEvent = () => {
    emit('toggle')
}
</script>
  
<style lang="scss">
@import "@/assets/scss/variables.scss";

.comp-header {
    header {
        // background-color: black; // rgb(45, 89, 90)
        background-color: #404344;
        background-color: #ceeaf0;
        background-color: $bg-dark-100;
        background-color: #2c3238;
        padding: 5px 20px;
        display: flex;
        justify-content: flex-start;
        gap: 25px;
        align-items: center;
        min-height: $header-height;
        height: $header-height;
        // border-bottom: .5px solid #fff;

        button[id="signout"] {
            font: inherit;
            background: lightblue;
            color: inherit;
            padding: 8px 16px;
            border: none;
            cursor: pointer;
            border-radius: 5px;
            font-weight: 400;
        }

        .burger {
            cursor: pointer;

            img {
                max-height: 28px;
            }
        }

        .logo {
            img {
                max-height: 28px;
                display: flex;
            }
        }
    }
}
</style>