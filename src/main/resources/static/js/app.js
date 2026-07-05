document.addEventListener("DOMContentLoaded", () => {
    document.querySelectorAll("[data-confirm]").forEach((link) => {
        link.addEventListener("click", (event) => {
            if (!confirm(link.dataset.confirm)) {
                event.preventDefault();
            }
        });
    });
});
