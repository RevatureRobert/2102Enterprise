const sum = require('../index')

describe("it should sum over the array", () => {
    it("1,2,3 should result in 6", () => {
        expect(sum([1,2,3])).toBe(7);
    })
})