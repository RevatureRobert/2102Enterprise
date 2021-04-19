
interface DecoratorStructure{

}
function dec1(input: DecoratorStructure){
    console.log("decorated");
    return function (target: any){
        console.log(target);
    }
}


@dec1({})
class something{
}