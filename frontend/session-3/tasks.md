- [x] clicking on the image from the header toggles the audio component to play/pause

- [x] when scrolling, if a section is in the middle of the screen, change its background, when it leaves the middle of the screen, reset it to its original value

- [x] I heard you like buttons...
  - [x] add a button in the aside element that when clicked inserts a new article in the main element, at the top.  
  - [x] Inside the newly created article there should be a button,  
  - [x] which when clicked adds a new section above itself, the section has 400 random alphabet characters.  

- [x] Bonus for myself: make it work properly using session-2 style.css
Notes: to keep both aside and main on the same line, I had to create a new flex container that uses nowrap. I also had to use min-width: 0 in this container in order to be able to shrink the content properly, otherwise for example the 400 characters string won't shrink below a point because the container thinks that main hit its content min-width and it shouldn't shrink the main further(or so I think... it has something to do with the min-width too, this guy explains it nicely here: https://stackoverflow.com/questions/36247140/why-dont-flex-items-shrink-past-content-size/36247448, the important stuff that helped me was at the "Nested Flex Containers" section)