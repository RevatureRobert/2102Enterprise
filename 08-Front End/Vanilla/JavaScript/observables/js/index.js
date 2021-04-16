console.log("connected");

/* 
"{"singleValue":{"synchronous":"object","asynchronous":"Promise"},"multipleValues":{"synchronous":"array","asynchronous":"observable"}}"
*/

// document.getElementById("button").addEventListener('click', (eve) =>{
//     console.log(eve)
// })

const click = rxjs.fromEvent(document.getElementById("button"), "click");
/* 

click.subscribe(val => console.log(val))

const newClick2 = click.pipe(rxjs.operators.map(x => x.clientX))
newClick2.subscribe(console.log)


*/
/* 


const arr = [6541,654,65,65,654
             ,654,564,654,654,654,564,564,546,564,654,564,564,56,564,564,56,56,23,453,74,564,41,4164,5,6553,4324,12,234,354,354,135,35,3542,345,34]
undefined
const obs = rxjs.of(arr)
undefined
obs.subscribe(console.log)
rxjs.umd.js:631 (40) [6541, 654, 65, 65, 654, 654, 564, 654, 654, 654, 564, 564, 546, 564, 654, 564, 564, 56, 564, 564, 56, 56, 23, 453, 74, 564, 41, 4164, 5, 6553, 4324, 12, 234, 354, 354, 135, 35, 3542, 345, 34]
const obs2 = rxjs.from(arr)
const obs3 = rxjs.from(arr)
undefined
obs3.subscribe(console.log)

const obs4 = rxjs.of(...arr)

*/

/* 

const promise = new Promise((resolve, reject) => {
    resolve("this is a resolved promise");
}

promise.then(console.log)
this is a resolved promise
Promise {<fulfilled>: undefined}
*/