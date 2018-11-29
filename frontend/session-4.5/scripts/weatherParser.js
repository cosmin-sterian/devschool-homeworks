function requestDataFromWeatherAPI(event, forecast, inputData) {
    event.preventDefault();
    console.log(event, forecast, inputData);

    let xhr = new XMLHttpRequest();

    if (!xhr) {
        alert("Can't create XMLHTTP instance");
        return false;
    }

    xhr.onreadystatechange = fetchData(xhr);
    if (forecast) {
        xhr.open('GET', `https://www.metaweather.com/api/location/${inputData}`);
    } else {
        xhr.open('GET', `https://www.metaweather.com/api/location/search/?query=${inputData}`);
    }
    xhr.send();
}

function fetchData(xhr) {
    console.log(xhr);
    console.log(xhr.status);
    if (xhr.readyState === XMLHttpRequest.DONE) {
        const forecastContainer = document.querySelector('#forecastContainer');
        forecastContainer.textContent = "";
        console.log(JSON.parse(xhr.responseText));
        if (xhr.status === 200) {
            console.log('success');
            forecastContainer.textContent = JSON.parse(xhr.responseText).message;
            console.log(forecastContainer.textContent);
        } else {
            forecastContainer.textContent = 'Content not found';
        }
    }
}

// module.exports = {
//     requestDataFromWeatherAPI
// };