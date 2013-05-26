/*Permet de selectionner les translations uniques ! */
SELECT * FROM lang_translation ta WHERE (SELECT COUNT(*) FROM lang_translation tb WHERE ta.key = tb.key AND ta.id_lang_language = tb.id_lang_language)> 1


/* Add key for language translation missing BUT MODIFY THE TWO 3s BECAUSE IT WILL CREATE DUPLICATES OTHERWISE*/
INSERT INTO lang_translation (`key`, `translation`, `id_lang_language`) 
(
SELECT `key`, "", 3 FROM lang_translation ta WHERE (SELECT COUNT(*) FROM lang_translation tb 
WHERE ta.key = tb.key AND tb.id_lang_language = 3) = 0 AND ta.id_lang_language = 1
);
