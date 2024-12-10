document.addEventListener("DOMContentLoaded", () => {
  const formsWrapper = document.querySelector(".forms-wrapper");
  const toggles = document.querySelectorAll(".toggle");

  if (formsWrapper) {
    toggles.forEach((toggle) => {
      toggle.addEventListener("click", () => {
        formsWrapper.classList.toggle("move-left");
      });
    });
  } else {
    console.error("Error: .forms-wrapper no se encuentra en el DOM.");
  }
});
