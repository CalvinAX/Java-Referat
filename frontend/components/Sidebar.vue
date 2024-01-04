<template>
    <aside class="sidebar-aside">
        <div class="sidebar-wrapper">
            <div class="sidebar-header">
                <div class="sidebar-logo">
                    <div class="placeholder-logo">

                    </div>
                </div>
            </div>
            <div class="sidebar-content">
                <nav class="sidebar-navigation">
                    <ul>
                        <NuxtLink :to="localePath('/')" class="sidebar-nav-item">
                            <li>
                                <div class="icon-text-container"><img src="@/assets/img/icons/ticket.svg"
                                        class="sidebar-icon" />{{ $t('sidebarHome') }}</div>
                            </li>
                        </NuxtLink>
                        <NuxtLink :to="localePath('/tickets')" class="sidebar-nav-item">
                            <li>
                                <div class="icon-text-container"><img src="@/assets/img/icons/ticket.svg"
                                        class="sidebar-icon" />{{ $t('sidebarTickets') }}</div>
                            </li>
                        </NuxtLink>
                    </ul>
                </nav>
            </div>
            <div class="sidebar-footer">
                <div class="sidebar-footer-content">
                    Footer
                    <LanguageSwitcher />
                    <nav class="sidebar-navigation">
                        <ul>
                            <button @click="handleSignOut" class="sidebar-nav-item sidebar-logout-btn">
                                <li>
                                    <div class="icon-text-container"><img src="@/assets/img/icons/ticket.svg"
                                            class="sidebar-icon" />{{ $t('logout') }}</div>
                                </li>
                            </button>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </aside>
</template>

<script setup>
const { signOut } = useAuth();

async function handleSignOut() {
    await signOut();
}

const localePath = useLocalePath();


</script>

<style lang="scss">
@import "@/assets/scss/variables.scss";

.sidebar-aside {
    position: -webkit-sticky;
    position: sticky;
    top: 0;
    left: 0;
    width: $sidebar-width;
}

.sidebar-wrapper {
    height: 100vh;
    width: $sidebar-width;
    background-color: $bg-dark-100;
    box-shadow: $box-shadow-sm;
}

.sidebar-header {
    width: 100%;
    display: flex;
    justify-content: center;
    padding: 24px 0;
}

.sidebar-logo {
    display: flex;
    justify-content: center;
}

.placeholder-logo {
    height: 64px;
    width: 64px;
    background-color: $brand-color;
}

.sidebar-content {
    width: 100%;
    padding: 24px 0;
    display: flex;
    justify-content: center;
}

.sidebar-icon {
    width: 24px;
    padding-right: 16px;
}

.sidebar-navigation {
    margin: 0;
    padding: 0;
    width: 100%;

    ul {
        list-style-type: none;
        margin: 0;
        padding: 0;

        .sidebar-nav-item {
            text-decoration: none;

            li {
                margin: 4px 12px;
                padding: 8px 0 8px 12px;
                color: $text-white-200;
                text-decoration: none;
                font-weight: 600;

                &:hover {
                    background-color: $btn-hover-100;
                    color: white;
                    border-radius: 8px;
                    transition: ease-in-out 0.2s;
                }
            }
        }
    }

    .icon-text-container {
        margin: 0;
        padding: 0;
        display: flex;
        align-items: center;
    }
}

.sidebar-footer {
    width: $sidebar-width;
    position: absolute;
    bottom: 0;
}

.sidebar-footer-content {
    color: $text-white-200;
    padding: 0;
}

.sidebar-logout-btn {
    width: 100%;
    padding: 0;
    margin: 0;
    background-color: transparent;
    border: 0;

    &:hover {
        cursor: pointer;
    }
}
</style>