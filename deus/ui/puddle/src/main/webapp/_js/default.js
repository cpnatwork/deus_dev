var _CPN_mailAddrP1 = "c.p.neumann";
var _CPN_mailAddrP2 = "gmail.de";
var _CPN_mailSubject = "DACUS::Feedback";

function viewTheUnspoken(linkText) {
	viewTheUnspokenCPN(linkText);
}
function viewTheUnspokenCPN(linkText) {
	viewTheUnspokenCPN_subj(linkText,_CPN_mailSubject);
}
function viewTheUnspokenCPN_subj(linkText, subject) {
	document.write('<a class="eMail" href=\"mailto:' + _CPN_mailAddrP1 + '@' + _CPN_mailAddrP2 + '?subject=' + subject + '\"' + ' >' + linkText + '</a>');
}
