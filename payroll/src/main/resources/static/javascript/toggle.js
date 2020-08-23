function setUpSingleCheckEvent(){

    let checkboxList = $('.checkbox-grp')

    $('.checkbox-grp').click(function(){

        //クリックされたとき、trueで、再クリックされたとき、falseになる
        //なので、それ以外をアンチェックしておくと単一チェックできる

        let self = $(this);

        let restCheckboxList = checkboxList.not(self);

        restCheckboxList.prop('checked',false);

    });

}

//ロード時に読み込まれる
$(function() {

    setUpSingleCheckEvent();

})