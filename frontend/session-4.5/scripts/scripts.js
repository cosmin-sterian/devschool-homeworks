const cityNameInput = document.querySelector("#cityName");
const cityIDInput = document.querySelector("#cityID");
const formButton = document.querySelector("#formButton");

cityIDInput.addEventListener('input', cityIDListener);

function cityIDListener(event) {
    if  (!event.target || event.target.value === '') {
        // Input is now empty
        formButton.textContent = 'Get Location';
    } else {
        formButton.textContent = 'Get Forecast';
    }
}