//Task 1
const headerImage = document.getElementById("img1");
const audioElement = document.getElementById("audio1");
var isPlaying = false;

(function(img_arg) {
    img_arg.addEventListener('click', function(event) {
        if (isPlaying) {
            audioElement.pause();
        } else {
            audioElement.play();
        }
    });
})(headerImage);

audioElement.onplaying = function() { isPlaying = true };
audioElement.onpause = function() { isPlaying = false };

//Task 2
function buildThreshholdList() {
    var thresholds = [0];
    var numSteps = 10;

    for(let i=1.0; i <= numSteps; i++) {
        var ratio = i/numSteps; // Btw, what's the difference between let and var?
        thresholds.push(ratio);
    }

    console.log(thresholds);
    return thresholds;
}

const intersectionThreshhold = 0.9;

function handleIntersect(entries, observer) {
    entries.forEach(entry => {
        var section = entry.target;
        if (entry.intersectionRatio > intersectionThreshhold) {
            section.classList.add('section-bg-change');
        } else {
            section.classList.remove('section-bg-change');
        }
    })
}

const options = {
    root: null,
    rootMargin: "0px",
    threshold: buildThreshholdList()
};

const observer = new IntersectionObserver(handleIntersect, options);
const sections = document.querySelectorAll('section');
sections.forEach(section => {
    observer.observe(section);
});