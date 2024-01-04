<template>
    <div class="language-switcher-wrapper">
        <div class="language-switcher-content">
            <span>{{ $t('language') }}</span>
            <select v-model="language" class="language-switcher">
                <option v-for="locale in locales" :key="typeof locale === 'object' ? locale.code : locale"
                    :value="typeof locale === 'object' ? locale.code : locale">{{ typeof locale === 'object' ? locale.name
                        : locale }}</option>
            </select>
        </div>
        <span class="flag">{{ $t("flag") }}</span>
    </div>
</template>

<script setup lang="ts">
const { locales, locale, setLocale } = useI18n();

const language = computed({
    get: () => locale.value,
    set: (value) => {
        setLocale(value);
    }
})


</script>

<style lang="scss">
@import "@/assets/scss/variables.scss";

.language-switcher-wrapper {
    width: 100%;

    .language-switcher-content {
        display: flex;
        justify-content: center;
        flex-direction: column;
        margin: 16px 0;
        gap: 5px;
        color: $text-white-100;
        // max-width: calc(100% - 20px);
        // align-items: center;
        padding-inline: 15px;

        &>span {
            padding-left: 5px;
            visibility: hidden;
        }

        .language-switcher {
            background-color: $btn-dark-100;
            padding: 8px 16px;
            border: 1px solid $bg-dark-300;
            border-radius: 6px;
            box-shadow: rgba(0, 0, 0, 0.15) 1.95px 1.95px 2.6px;
            color: $text-white-100;
        }
    }
}
</style>

<style>
.language-switcher-wrapper {
    container-type: inline-size;
    container-name: language;
}

.language-switcher-wrapper .flag {
        background-color: green;
    }

@container language (max-width: 300px) {
    .language-switcher-content {
        /* display: none; */
    }

    .flag {
        background-color: red;
    }
}
</style>