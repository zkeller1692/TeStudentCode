// add pageTitle
const pageTitle = 'My Shopping List'
// add groceries
let groceries = ['apples', 'bananas', 'milk', 'eggs', 'ice cream', 'toilet paper', 'beer', 'vodka', 'red wine', 'white wine'];
/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  document.getElementById('title').innerText = pageTitle;
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
  let groceryElement = document.getElementById('groceries');
  groceries.forEach(groceryItem => {
    let listItem = document.createElement('li')
    groceryElement.insertAdjacentElement('afterbegin', listItem);
    listItem.innerText = groceryItem;
  });
  // for(let i = 0; i < groceries.length; i++){
  //    let listItem = document.createElement('li')
  //    groceryElement.insertAdjacentElement('afterbegin', listItem);
  //   listItem.innerText = groceries[i];
  // }
}

/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {
  const nodeList = document.querySelectorAll('li');
    for(let i = 0; i < nodeList.length; i++) {
      nodeList[i].classList.add('completed');
    }
}

setPageTitle();

displayGroceries();

// Don't worry too much about what is going on here, we will cover this when we discuss events.
document.addEventListener('DOMContentLoaded', () => {
  // When the DOM Content has loaded attach a click listener to the button
  const button = document.querySelector('.btn');
  button.addEventListener('click', markCompleted);
});
