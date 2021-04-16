/* 
const h1 = document.getElementsByTagName("h1")
undefined
h1.innerHTML += " and something from js"
"undefined and something from js"
h1
HTMLCollection [h1, innerHTML: "undefined and something from js"]
h1[0].innerHTML += " and something from js"
"DOM DOM DOMMMMM!!!! and something from js"
h1[0].style = {...h1.style, color:'red'}
{color: "red"}
h1[0].style = {...h1[0].style, color:'red'}
{alignContent: "", alignItems: "", alignSelf: "", alignmentBaseline: "", all: "", …}
h1[0].style.color = 'red'
"red"
const arr = [5,6541,54,564,165,165,156,165,165,651]
undefined
const arr2 = [arr, 156,165,651,651]
undefined
arr2.length
5
arr2
(5) [Array(10), 156, 165, 651, 651]0: Array(10)0: 51: 65412: 543: 5644: 1655: 1656: 1567: 1658: 1659: 651length: 10__proto__: Array(0)1: 1562: 1653: 6514: 651length: 5__proto__: Array(0)
const arr3 = [...arr2, 54,465,465,64,654]
undefined
arr3.length
10
const obj = {a:8,b:9,c:10}
undefined
obj
{a: 8, b: 9, c: 10}
const obj2 = {...obj, c:11}
undefined
obj2
{a: 8, b: 9, c: 11}


const p = document.createElement("p")
undefined
p.innerText="this is from js"
"this is from js"
h1[0].append(p)
undefined
h1[0].appendChild(p)
<p>​this is from js​</p>​
document.getElementsByTagName('p')[1].appendChild(p)
<p>​this is from js​</p>​
h1[0].appendChild(p)
<p>​this is from js​</p>​
document.getElementsByTagName('p')[1].appendChild(p)
<p>​this is from js​</p>​
docuem
VM3481:1 Uncaught ReferenceError: docuem is not defined
    at <anonymous>:1:1
(anonymous) @ VM3481:1
document.body.appendChild(p)
<p>​this is from js​</p>​
p.setAttribute("style","color:blue")
undefined


function sayHi(){
    alert("hello user");
}
undefined
document.getElementById("button").addEventListener("click",sayHi)
undefined
function callFun(fun){
    fun("something");
}
undefined
callFun(sayHi)
undefined
function printParam(param){
    console.log(param);
}
undefined
document.getElementById("button").addEventListener("click",printParam)
undefined

PointerEvent {isTrusted: true, pointerId: 1, width: 1, height: 1, pressure: 0, …}
altKey: false
altitudeAngle: 1.5707963267948966
azimuthAngle: 0
bubbles: true
button: 0
buttons: 0
cancelBubble: false
cancelable: true
clientX: 84
clientY: 125
composed: true
ctrlKey: false
currentTarget: null
defaultPrevented: false
detail: 1
eventPhase: 0
fromElement: null
height: 1
isPrimary: false
isTrusted: true
layerX: 84
layerY: 125
metaKey: false
movementX: 0
movementY: 0
offsetX: 74
offsetY: 9.125
pageX: 84
pageY: 125
path: (5) [button#button, body, html, document, Window]
pointerId: 1
pointerType: "mouse"
pressure: 0
relatedTarget: null
returnValue: true
screenX: -1282
screenY: 228
shiftKey: true
sourceCapabilities: InputDeviceCapabilities {firesTouchEvents: false}
srcElement: button#button
tangentialPressure: 0
target: button#button
tiltX: 0
tiltY: 0
timeStamp: 221969.4849999796
toElement: null
twist: 0
type: "click"
view: Window {window: Window, self: Window, document: document, name: "", location: Location, …}
which: 1
width: 1
x: 84
y: 125
__proto__: PointerEvent



function printParam(param){
    console.log(param);
}
undefined
document.getElementById("outer").onclick=printParam
ƒ printParam(param){
    console.log(param);
}
document.getElementById("inner").onclick=printParam
ƒ printParam(param){
    console.log(param);
}
document.getElementById("button").onclick=printParam
ƒ printParam(param){
    console.log(param);
}
VM5946:2 PointerEvent {isTrusted: true, pointerId: 1, width: 1, height: 1, pressure: 0, …}
VM5946:2 PointerEvent {isTrusted: true, pointerId: 1, width: 1, height: 1, pressure: 0, …}
VM5946:2 PointerEvent {isTrusted: true, pointerId: 1, width: 1, height: 1, pressure: 0, …}
VM5946:2 PointerEvent {isTrusted: true, pointerId: 1, width: 1, height: 1, pressure: 0, …}
VM5946:2 PointerEvent {isTrusted: true, pointerId: 1, width: 1, height: 1, pressure: 0, …}
printParam = function (eve)_{
VM6061:1 Uncaught SyntaxError: Unexpected identifier
printParam = function (eve){
    alert(this.id, eve.target.id);
}
ƒ (eve){
    alert(this.id, eve.target.id);
}
VM5946:2 PointerEvent {isTrusted: true, pointerId: 1, width: 1, height: 1, pressure: 0, …}
VM5946:2 PointerEvent {isTrusted: true, pointerId: 1, width: 1, height: 1, pressure: 0, …}
VM5946:2 PointerEvent {isTrusted: true, pointerId: 1, width: 1, height: 1, pressure: 0, …}
document.getElementById("outer").onclick=printParam
ƒ (eve){
    alert(this.id, eve.target.id);
}
document.getElementById("inner").onclick=printParam
ƒ (eve){
    alert(this.id, eve.target.id);
}
document.getElementById("button").onclick=printParam
ƒ (eve){
    alert(this.id, eve.target.id);
}
printParam = function (eve){
    alert(this.id + "     " + eve.target.id);
}
ƒ (eve){
    alert(this.id + "     " + eve.target.id);
}
document.getElementById("outer").onclick=printParam
ƒ (eve){
    alert(this.id + "     " + eve.target.id);
}
document.getElementById("inner").onclick=printParam
ƒ (eve){
    alert(this.id + "     " + eve.target.id);
}
document.getElementById("button").onclick=printParam
ƒ (eve){
    alert(this.id + "     " + eve.target.id);


    printParam = function (eve){
    alert(this.id + "     " + eve.target.id);
}
ƒ (eve){
    alert(this.id + "     " + eve.target.id);
}
document.getElementById('outer').addEventListener('click', printParam, {capture:true})
undefined
document.getElementById('inner').addEventListener('click', printParam, {capture:true})
undefined
document.getElementById('button').addEventListener('click', printParam, {capture:true})
undefined


printParam = function (eve){
    alert(this.id + "     " + eve.target.id);
}
ƒ (eve){
    alert(this.id + "     " + eve.target.id);
}
document.getElementById('outer').addEventListener('click', printParam, {capture:true})
undefined
printParamQuit = function (eve){
    alert(this.id + "     " + eve.target.id);
}
ƒ (eve){
    alert(this.id + "     " + eve.target.id);
}
printParamQuit = function (eve){
    alert(this.id + "     " + eve.target.id); eve.stopPropagation()
}
ƒ (eve){
    alert(this.id + "     " + eve.target.id); eve.stopPropagation()
}
document.getElementById('inner').addEventListener('click', printParamQuit, {capture:true})
undefined
document.getElementById('button').addEventListener('click', printParam, {capture:true})
undefined
*/

// hoisting
mew(); // works as normal
console.log(hey); // undefined
// console.log(something);  //something

function mew() {
  console.log("meeeeeeeeeew");
  console.log(hey);
}

var hey = "hey";
let something = "something";

// ajax
/// ajax = asynchronous javascript and xml

const xhr = new XMLHttpRequest();

// xhr.onreadystatechange = function () {
//     if(xhr.readyState==4 && xhr.status == 200){
//         const text = xhr.responseText;
//         console.log(JSON.parse(text));
//     }
// };

// xhr.open("GET", "https://pokeapi.co/api/v2/pokemon/2")
// xhr.send();

// fetch("https://pokeapi.co/api/v2/pokemon/2")
//   .then((response) => response.json())
//   .then(console.log);
async function call(){
    const fetched = await fetch("https://pokeapi.co/api/v2/pokemon/2")
    const json = await fetched.json()
    console.log(json);
}
// console.log("here");

// setTimeout(() => {
//     console.log("time is up")
// }, 500);

// setInterval(() => {
//     console.log("its time for another")
// }, 500)

// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
// console.log("here")
