export class FirstClass{
    // we can use modifiers in the constructor params to declare them as
    //      fields
    constructor( readonly name:string, readonly age:number){
        // this.name=name;
        // this.age=age;
    }
    /*  
    in ts we still get our access modifiers and our non access modifiers
        access modifiers:
            private public(implicit) protected
        non access modifiers
            static readonly(final)
     */
    // private readonly name:string;
    // private age:number;
}

class SecondClass {
    // in ts, we can have 'optional params'
    constructor(readonly name, readonly age?:number, temp?:string){
        console.log(temp);
    }
}

interface One{}
interface Two{}
class ThirdClass extends FirstClass implements  One, Two{
    
    something(x:number){
        let some:string;
        if(x > 5) {
            some='true'
        }
        return some!.toString()


    }
}
class SomeClass {
    constructor(private num:number){}

}

const first: FirstClass = new FirstClass("hey", 4);
const second = new SecondClass('name');