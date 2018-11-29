let xhr;
let forecastBoolean;
function requestDataFromWeatherAPI(event, forecast, inputData) {
    event.preventDefault();
    // console.log(event, forecast, inputData);

    xhr = new XMLHttpRequest();
    forecastBoolean = forecast;

    if (!xhr) {
        alert("Can't create XMLHTTP instance");
        return false;
    }

    xhr.onreadystatechange = fetchData;
    if (forecast) {
        xhr.open('GET', `https://www.metaweather.com/api/location/${inputData}`);
    } else {
        xhr.open('GET', `https://www.metaweather.com/api/location/search/?query=${inputData}`);
    }
    xhr.send();
}

function fetchData() {
    // console.log(xhr);
    // console.log(xhr.status);
    if (xhr.readyState === XMLHttpRequest.DONE) {
        const forecastContainer = document.querySelector('#forecastContainer');
        forecastContainer.style.display = "inline-block";
        forecastContainer.textContent = "";
        // console.log(JSON.parse(xhr.responseText)[0]);
        if (xhr.status === 200) {
            // console.log('success');
            const response = JSON.parse(xhr.responseText);
            if (forecastBoolean) {
                forecastContainer.textContent = response.consolidated_weather[0].weather_state_name;
            } else {
                forecastContainer.textContent = response[0].woeid;
            }
            
            // console.log(forecastContainer.textContent);
        } else {
            forecastContainer.textContent = 'Content not found';
        }
    }
}

// module.exports = {
//     requestDataFromWeatherAPI
// };