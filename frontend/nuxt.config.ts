// https://nuxt.com/docs/api/configuration/nuxt-config
export default defineNuxtConfig({
  devtools: { enabled: true },
  modules: [
    '@nuxtjs/i18n',
    '@sidebase/nuxt-auth',
    '@nuxt/image',
    '@nuxtjs/color-mode',
  ],
  css: [
    '@/assets/scss/main.scss',
  ],
  i18n: {
    lazy: true,
    langDir: 'locales',
    strategy: 'prefix_except_default',
    locales: [
      {
        code: 'en-US',
        iso: 'en-US',
        name: 'English(US)',
        file: 'en-US.json',
      },
      {
        code: 'de-DE',
        iso: 'de-DE',
        name: 'Deutsch',
        file: 'de-DE.json',
      },
    ],
    defaultLocale: 'en-US',
  },
  app: {
    head: {
        link: [
            {
                rel: 'preconnect',
                href: 'https://fonts.googleapis.com'
            },
            {
                rel: 'preconnect',
                href: 'https://fonts.gstatic.com'
            },
            {
                rel: 'stylesheet',
                href: 'https://fonts.googleapis.com/css2?family=Outfit:wght@100;200;300;400;500;600;700;800;900&display=swap'
            },
        ]
    }
}
})
