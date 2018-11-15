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
const sections = document.querySelectorAll('section');

var isInViewport = function(elem) {
    var bounding = elem.getBoundingClientRect();
    return (
        bounding.top >= 0 &&
        bounding.left >=0 &&
        bounding.bottom <= (window.innerHeight || document.documentElement.clientHeight) &&
        bounding.right <= (window.innerWidth || document.documentElement.clientWidth)
    );
};

sections.forEach(function(section) {
    section.addEventListener('scroll', function(event) {
        console.log(event);
        if (isInViewport(section)) {
            section.classList.toggle('section-bg-change');
        }
    });
});