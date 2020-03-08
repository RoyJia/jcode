import re

text = '1.18k.r8,56 kr.'

grouping_separator = '.'
decimal_separator = ','

us_grouping_separator = ','
us_decimal_separator = '.'

temp_grouping_separator = '?'
temp_decimal_separator = ';'

reformat_text = '1,188.56 kr.'

reformat_text = re.sub('(?<=\d)\{0}(?=\d)'.format(us_grouping_separator), temp_grouping_separator, reformat_text)
print("---" + reformat_text)
reformat_text = re.sub('(?<=\d)\{0}(?=\d)'.format(us_decimal_separator), temp_decimal_separator, reformat_text)
print("+++" + reformat_text)
reformat_text = re.sub('(?<=\d)\{0}(?=\d)'.format(temp_grouping_separator), grouping_separator, reformat_text)
print("---" + reformat_text)
reformat_text = re.sub('(?<=\d)\{0}(?=\d)'.format(temp_decimal_separator), decimal_separator, reformat_text)
print("+++" + reformat_text)




def get_separators(text, default_separator):
    separator_indexs = []
    list_sample = list(text)
    for index, item in enumerate(list_sample):
        if (
            index > 0 and 
            index < len(list_sample) - 1 and
            list_sample[index - 1].isnumeric() and
            list_sample[index + 1].isnumeric()
            ):
            item == default_separator and separator_indexs.append(index)

    return separator_indexs

print(get_separators(text, grouping_separator))