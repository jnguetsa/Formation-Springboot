module.exports = {
  content: [
    "./src/main/resources/templates/**/*.{html,js}", // Inclut les fichiers Thymeleaf
    "./src/main/resources/static/**/*.{html,js}",
  ],
  theme: {
    extend: {},
  },
  plugins: [require("daisyui")],
};