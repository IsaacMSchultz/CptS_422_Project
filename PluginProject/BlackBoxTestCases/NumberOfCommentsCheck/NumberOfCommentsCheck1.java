/*
* Description: This class checks the number of comments
* check if it counts comment blocks as one. 
* This comment counts as one
* Result should be 6
*/

class NumberOfCommentsCheck1 {
    // a single line of comments should count once

    //two single line comments
    //one after the other, like this, should count once

    /*one line of a block comment should count once*/

    /*multiple
    lines
    of
    a 
    block
    comment
    should
    count
    once
    */

    int i = 0; //inline comments should be counted
}