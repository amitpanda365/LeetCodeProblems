/**
 * @param {number[]} arr
 * @return {boolean}
 */
var uniqueOccurrences = function(arr) {
    const map = new Map();
    for(let i of arr){
        map.set(i, (map.get(i) || 0)+1);
    }

    return map.size === new Set(map.values()).size;
};