const cityNameInput = document.querySelector("#cityName");
const cityIDInput = document.querySelector("#cityID");
const formButton = document.querySelector("#formButton");

cityIDInput.addEventListener('input', cityIDListener);

function cityIDListener(event) {
    // console.log(event);
    // console.log(event.target.value);
    if  (!event.target || event.target.value === '') {
        // Input is now empty
        // console.log(!event.value);
        formButton.textContent = 'Get Location';
        // console.log('button should now be Get Location, but it is ' + formButton.textContent);
    } else {
        formButton.textContent = 'Get Forecast';
        // console.log('button should now be Get Forecast, but it is ' + formButton.textContent);
    }
}