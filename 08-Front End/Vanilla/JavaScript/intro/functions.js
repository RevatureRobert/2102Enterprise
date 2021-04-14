// IIFE Immediately Invokable Function Expression
const pupps = (function () {
  console.log("anonymous");
  return "puppies";
})();

console.log(pupps);

// closure
const doMany = (function () {
  let count = 0;
  return function (num = 0 /* default parameter*/) {
    console.log(num);
    console.log((count += num));
  };
})();
// const doOnce = function (){
//     console.log("anonymous");
// }

doMany(700);
doMany(700);
doMany("");
doMany();
doMany();
doMany();
doMany();
doMany();
doMany();
doMany();

//arrow functions
//function makeHappy...
var makeHappy = function () {
  return "be happy or i will concat this cat to your head?";
};

const forceHappiness = (val) => {
  return "I will fat arrow you up if you dont get happy";
};

const obj = {
    name: "howard the duck",
    sayNameFun: function (){
        console.log(this.name);
    },
    sayNameArrow: () => {
        console.log(this.name);
    },
}
// console.log(globalThis);
// obj.sayNameFun();
// obj.sayNameArrow();

// es6 class syntax... but it is just sugar syntax
class TestClass {
    constructor(name){
        this._name = name;
    }

    get name() {
        return this._name;
    }

    set name(name){
        this._name = name;
    }

    myMethod(){
        console.log("this is a method");
    }
}


const test = new TestClass("meh");
test.name = "something";
console.log(test.name);
test.myMethod();

// console.log(typeof TestClass);


function TestClass2(name){
    this._name = name;
    this.name = function (funname){
        if(!funname){
            return this._name;
        } else {
            this._name = funname;
        }
    }
    this.myMethod = function (){
        console.log("this is a method");
    }
}

const test2 = new TestClass2("something");
console.log(test2.name());
test2.myMethod();

console.log(typeof TestClass.prototype);