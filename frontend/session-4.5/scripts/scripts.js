const cityNameInput = document.querySelector("#cityName");
const cityIDInput = document.querySelector("#cityID");
const formButton = document.querySelector("#formButton");
let forecast = false;
let inputData = 'Bucharest'; // Default value

cityIDInput.addEventListener('input', cityIDListener);

formButton.addEventListener('click', event =>
    requestDataFromWeatherAPI(event, forecast, inputData)
);

function cityIDListener(event) {
    if  (!event.target || event.target.value === '') {
        // Input is now empty
        formButton.textContent = 'Get Location';
        forecast = false;
        inputData = cityNameInput.value || 'Bucharest';
    } else {
        formButton.textContent = 'Get Forecast';
        forecast = true;
        inputData = event.target.value;
    }
}