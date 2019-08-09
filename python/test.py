

def test_fun(aaa=False):
    print(aaa)
    if aaa:
        print("aaa has value")
    else:
        print("aaa does not have value")


test_fun()

test_fun(aaa="I'm a string")