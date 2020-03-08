import re
import uuid

source = "d 'de' MMM 'de' yyyy"


def _replace_special_charactors(source):
    pattern = re.compile(r"\'\w.{0,3}\'")

    match = pattern.search(source, 0)
    pairs = []
    while match:
        span = match.span()
        temp_str = str(uuid.uuid4())
        pairs.append((temp_str, match.group()))
        source = source[:span[0]] + temp_str + source[span[1]:]
        match = pattern.search(source, 0)

    return source, pairs


format_pattern, pairs = _replace_special_charactors(source)

print(format_pattern)

[print(item) for item in pairs]