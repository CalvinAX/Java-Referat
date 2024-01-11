<template>
    <nav class="sidebar-comp">
        <ul role="list">
            <li>
                <NuxtLink to="/tickets">
                    <span class="icon">
                        <svg xmlns="http://www.w3.org/2000/svg" height="30" width="32" viewBox="0 0 576 512" fill="white">
                            <path
                                d="M575.8 255.5c0 18-15 32.1-32 32.1h-32l.7 160.2c0 2.7-.2 5.4-.5 8.1V472c0 22.1-17.9 40-40 40H456c-1.1 0-2.2 0-3.3-.1c-1.4 .1-2.8 .1-4.2 .1H416 392c-22.1 0-40-17.9-40-40V448 384c0-17.7-14.3-32-32-32H256c-17.7 0-32 14.3-32 32v64 24c0 22.1-17.9 40-40 40H160 128.1c-1.5 0-3-.1-4.5-.2c-1.2 .1-2.4 .2-3.6 .2H104c-22.1 0-40-17.9-40-40V360c0-.9 0-1.9 .1-2.8V287.6H32c-18 0-32-14-32-32.1c0-9 3-17 10-24L266.4 8c7-7 15-8 22-8s15 2 21 7L564.8 231.5c8 7 12 15 11 24z" />
                        </svg>
                    </span>
                    <span class="nav-text">{{ $t('sidebarHome') }}</span>
                </NuxtLink>
            </li>
            <li>
                <NuxtLink to="/tickets">
                    <span class="icon">
                        <!-- <svg xmlns="http://www.w3.org/2000/svg" height="16" width="18" viewBox="0 0 576 512" fill="white">
                            <path
                                d="M0 128C0 92.7 28.7 64 64 64H512c35.3 0 64 28.7 64 64v64c0 8.8-7.4 15.7-15.7 18.6C541.5 217.1 528 235 528 256s13.5 38.9 32.3 45.4c8.3 2.9 15.7 9.8 15.7 18.6v64c0 35.3-28.7 64-64 64H64c-35.3 0-64-28.7-64-64V320c0-8.8 7.4-15.7 15.7-18.6C34.5 294.9 48 277 48 256s-13.5-38.9-32.3-45.4C7.4 207.7 0 200.8 0 192V128z" />
                        </svg> -->
                        <svg xmlns="http://www.w3.org/2000/svg" height="16" width="18" fill="white" viewBox="0 0 576 512">
                            <path
                                d="M64 64C28.7 64 0 92.7 0 128v64c0 8.8 7.4 15.7 15.7 18.6C34.5 217.1 48 235 48 256s-13.5 38.9-32.3 45.4C7.4 304.3 0 311.2 0 320v64c0 35.3 28.7 64 64 64H512c35.3 0 64-28.7 64-64V320c0-8.8-7.4-15.7-15.7-18.6C541.5 294.9 528 277 528 256s13.5-38.9 32.3-45.4c8.3-2.9 15.7-9.8 15.7-18.6V128c0-35.3-28.7-64-64-64H64zm64 112l0 160c0 8.8 7.2 16 16 16H432c8.8 0 16-7.2 16-16V176c0-8.8-7.2-16-16-16H144c-8.8 0-16 7.2-16 16zM96 160c0-17.7 14.3-32 32-32H448c17.7 0 32 14.3 32 32V352c0 17.7-14.3 32-32 32H128c-17.7 0-32-14.3-32-32V160z" />
                        </svg>
                    </span>
                    <span class="nav-text">{{ $t('sidebarTickets') }}</span>
                </NuxtLink>
            </li>
            <li>
                <NuxtLink to="/tickets/create">
                    <span class="icon">
                        <!-- <svg xmlns="http://www.w3.org/2000/svg" height="16" width="14" fill="white" viewBox="0 0 448 512">
                            <path
                                d="M256 80c0-17.7-14.3-32-32-32s-32 14.3-32 32V224H48c-17.7 0-32 14.3-32 32s14.3 32 32 32H192V432c0 17.7 14.3 32 32 32s32-14.3 32-32V288H400c17.7 0 32-14.3 32-32s-14.3-32-32-32H256V80z" />
                        </svg> -->
                        <svg xmlns="http://www.w3.org/2000/svg" height="16" width="14" fill="white" viewBox="0 0 448 512">
                            <path
                                d="M64 32C28.7 32 0 60.7 0 96V416c0 35.3 28.7 64 64 64H384c35.3 0 64-28.7 64-64V96c0-35.3-28.7-64-64-64H64zM200 344V280H136c-13.3 0-24-10.7-24-24s10.7-24 24-24h64V168c0-13.3 10.7-24 24-24s24 10.7 24 24v64h64c13.3 0 24 10.7 24 24s-10.7 24-24 24H248v64c0 13.3-10.7 24-24 24s-24-10.7-24-24z" />
                        </svg>
                    </span>
                    <span class="nav-text">Create</span>
                </NuxtLink>
            </li>
            <div class="nav-bottom">
                <!-- <li> -->
                <!-- <LanguageSwitcher /> -->
                <!-- </li> -->
                <!-- <li>
                    <NuxtLink to="#">
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" height="30" width="30" viewBox="0 0 512 512"
                                fill="white" style="rotate: 180deg;">
                                <path
                                    d="M502.6 278.6c12.5-12.5 12.5-32.8 0-45.3l-128-128c-12.5-12.5-32.8-12.5-45.3 0s-12.5 32.8 0 45.3L402.7 224 192 224c-17.7 0-32 14.3-32 32s14.3 32 32 32l210.7 0-73.4 73.4c-12.5 12.5-12.5 32.8 0 45.3s32.8 12.5 45.3 0l128-128zM160 96c17.7 0 32-14.3 32-32s-14.3-32-32-32L96 32C43 32 0 75 0 128L0 384c0 53 43 96 96 96l64 0c17.7 0 32-14.3 32-32s-14.3-32-32-32l-64 0c-17.7 0-32-14.3-32-32l0-256c0-17.7 14.3-32 32-32l64 0z" />
                            </svg>
                        </span>
                        <span class="nav-text">{{ $t('logout') }}</span>
                    </NuxtLink>
                </li> -->
                <!-- <li>
                    <NuxtLink to="#">
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" height="30" width="32" viewBox="0 0 576 512"
                                fill="white">
                                <path
                                    d="M575.8 255.5c0 18-15 32.1-32 32.1h-32l.7 160.2c0 2.7-.2 5.4-.5 8.1V472c0 22.1-17.9 40-40 40H456c-1.1 0-2.2 0-3.3-.1c-1.4 .1-2.8 .1-4.2 .1H416 392c-22.1 0-40-17.9-40-40V448 384c0-17.7-14.3-32-32-32H256c-17.7 0-32 14.3-32 32v64 24c0 22.1-17.9 40-40 40H160 128.1c-1.5 0-3-.1-4.5-.2c-1.2 .1-2.4 .2-3.6 .2H104c-22.1 0-40-17.9-40-40V360c0-.9 0-1.9 .1-2.8V287.6H32c-18 0-32-14-32-32.1c0-9 3-17 10-24L266.4 8c7-7 15-8 22-8s15 2 21 7L564.8 231.5c8 7 12 15 11 24z" />
                            </svg>
                        </span>
                        <span class="nav-text">Tickets</span>
                    </NuxtLink>
                </li> -->
            </div>
        </ul>
    </nav>
</template>

<script setup lang="ts">
</script>

<style lang="scss">
@import "@/assets/scss/variables.scss";

nav.sidebar-comp {
    background-color: #1c2024;
    background-color: $bg-dark-100;
    background-color: #181b1f;

    ul {
        // margin-top: 2em;
        // margin-inline: 22px;
        padding: 0;
        list-style: none;
        padding: 10px $sidebar-inline-padding;
        height: 100%;

        display: flex;
        flex-direction: column;

        li {
            &:not(:first-child) {
                margin-top: 10px;
            }

            height: 50px;
            display: flex;
            align-items: center;
            border-radius: 6px;
            overflow: hidden;

            a {
                height: 100%;
                width: 100%;
                display: flex;
                align-items: center;
                padding-inline: auto;
                text-decoration: none;
                color: $text-white-100;
                gap: 15px;

                .icon {
                    min-width: calc($sidebar-width-closed - 2 * $sidebar-inline-padding);
                    font-size: 20px;
                    display: flex;
                    justify-content: center;
                    align-items: center;

                    svg {
                        height: 25px;
                        width: 27px;
                    }
                }

                .nav-text {
                    flex: 1;
                }

                &:hover {
                    background-color: $brand-color; // rgb(123, 64, 182)
                    background-color: #2c3238;
                }
            }
        }

        .nav-bottom {
            margin-top: auto;
        }
    }
}
</style>


<!-- smallest device width: 320px, 370px -->