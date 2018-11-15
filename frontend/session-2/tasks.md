Tasks:
[x] add a seamless background pattern to the body of the page
[x] import and use a custom font of your choice, only for headings (h1-h6)
[x] set the size of the page content so that it does not expand beyond 1600px
[?] style all states of the nav links, make sure the :visited state is the same as the default one, think of accessibility
//":visited state is the same as the default one, what does it mean?
[x] using flexbox for the entire layout of the page, arrange the aside and main elements to be next to each other, aside on the left, main on the right
//But if I include the header in the flexbox, it doesn't look nice anymore
//I think it's fixed now usign flex-basis: 100%. Note: if using 100vw, it uses the entire screen, passing that 1600px width limit from the body parent
[x] aside should have a maximum width of 350px and main should take up all available space
[x] between all elements (header, aside, main, footer) there should be a distance (gutter) of 30px;
// Setting a margin messes the main, it won't take all the available space
// ^ fixed using 'flex: 1 0 auto' in the main.flex-item
[ ] as you scroll the page, the nav should stick to the top of the page when you go past its position