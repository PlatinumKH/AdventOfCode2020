const fs = require('fs')

fs.readFile('input.txt', 'utf8', function (err,data) {
  if (err) {
    return console.log(err);
  }
  let numbers = data.split('\n');

  var answer = solve(numbers);

  console.log(answer);
});

function solve(numberArray){
	var primaryIndex = 0;
	var answer = -1;
	numberArray.forEach(function(element) {
		element = parseInt(element);
		var index;
		for (index = 0; index < 200; index++){
			if (primaryIndex != index){
				var secondNumber = parseInt(numberArray[index]);
				if (element + secondNumber === 2020){
					answer = element*secondNumber;
					return
				} 
			}
		}
		primaryIndex += 1;
	})
	return answer;
}