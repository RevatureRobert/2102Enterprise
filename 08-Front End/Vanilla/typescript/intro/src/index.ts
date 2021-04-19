/* 
data types
    number, string, boolean, object, function, undefined, null,
        bigInt, symbol, any, enum, tuple, never, void

since ts is a superset of js, any and all js will work in ts
*/


interface ISomething{
    name: string;
    age: number;
    speak: (saying: string) => void;
}

const obj: ISomething = {
    name: 'something',
    age: 55,
    speak: (saying: string) => console.log(saying)
}

interface IInput {
    username:string;
    password:string;
    email:string;
    captchaValidation: boolean;
}

