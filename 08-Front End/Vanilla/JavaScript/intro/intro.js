// console.log('hello world');
//declare a variable

// js is a loosely typed language so you do not declare the types

// difference between var let and const
//  const makes a constant
//  var and let => let has block scope

var a = 5;
let b = 5;
const c = 5;


//scopes
//  a is in global scope
function carry(person){
    if(person == null){
        console.log("cannot carry nothing");
    } else {
        let heavy = person.weight;
        console.log('too heavy, the weight it: '+heavy);
    }
    console.log(heavy);
}

// carry();

// types
// numbers => number
// characters => string
// boolean => boolean but...
// lacks value => null, undefined
// aside from primitives
//      objects and functions
// newly added types
//      symbol and bigInt

// truthy and falsey values
//      falsey: 0, "", false, null, undefined, NaN
let something = -0;
if(something){
    console.log(something + " something is true");
} else {
    console.log("something is false");
}
// console.log(0 === -0);
// === strict comparison
// == loose comparison
const num = Number('dfaslkfgjklngsarkljsf5') // NaN not a number
// const num = parseInt('25',16);
// console.log(num);
// console.log(isNaN('fskjsrgjhn3'))
// console.log(5 === '5');


// console.log(typeof 7);
// console.log(typeof "7");
// console.log(typeof true)
// console.log(typeof NaN);
// console.log(NaN+5);
// console.log(typeof undefined);
// console.log(typeof null);
// console.log(typeof Object);
// console.log(typeof Function);



// objects and prototypal inheritance
const obj = {
    id: 1,
    name: 'stringy',
    badMood: false,
    sayHello: function sayHello(){
        return "hello";
    },
    age: 598
}

const obj2 = {
    name: 'stringy',
    badMood: false,
}

console.log(obj.sayHello());
console.log(obj.name);
console.log(obj.toString());
console.log(obj2.toString());

// obj.__proto__.toString = function() {
    obj.toString = function (){
    return "hello from the inside";
}
console.log(obj.toString());
console.log(obj2.toString());


