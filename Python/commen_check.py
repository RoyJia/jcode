from bs4 import BeautifulSoup

def element_xpath_location(element):
    components = []
    child = element if element.name else element.parent

    for parent in child.parents:
        siblings = parent.find_all(child.name, recursive=False)
        tag_name = '/' + child.name if child.name == 'tr' else child.name
        components.append(f'{tag_name}[{1 + siblings.index(child)}]')
        child = parent
    components.reverse()
    return '/%s' % '/'.join(components)

soup = BeautifulSoup("""
<html>
<body>
        <div class="product-price-list trip-summary-list clearfix pkg-summary">
        <ul class="nobullet remove-margin">


                
    <li id="amtFlightHotel" class="clearfix tsPriceRow  ">
        <span id="lbl_amtFlightHotel">
                Starting price
        </span>
        <span class="right" id="val_amtFlightHotel">
                £307.32
            </span>
    </li>

                
    <li id="groundTransport" class="clearfix tsPriceRow hidden tsLxItem">
    </li>

                
    <li id="activities" class="clearfix tsPriceRow hidden tsLxItem">
    </li>



                    
    <li id="amtSavings" class="clearfix tsPriceRow  ">
        <span id="lbl_amtSavings">
<a href="#yourSavings" data-control="tooltip" role="button" data-trigger="click" data-width="300" data-arrow="true" data-fade="out" data-tooltip-id="yourSavingsTooltip" data-manual="none" data-show-tooltip="true" data-tooltip-classes="yourSavingsTooltip" data-tab-access="click">Package savings</a><div id="yourSavings" class="hidden">          This is the amount you saved by bundling a flight and hotel together, including any discounts.   </div>
        </span>
        <span class="right" id="val_amtSavings">
                -£7.30
            </span>
    </li>

                <li id="itemPriceSummary" class="mob">
    
    <li id="airlineCardFee" class="clearfix tsPriceRow hidden ">
    </li>


    
<li id="taxesAndFees" class="clearfix tsPriceRow  ">
        <span id="lbl_taxesAndFees">
                Taxes &amp; Fees
        </span>
        <span class="right" id="val_taxesAndFees">
                £95.98
            </span>
    </li>


    
    <li id="expediaBookingFee" class="clearfix tsPriceRow hidden ">
    </li>


    
    <li id="discount" class="clearfix tsPriceRow hidden ">
    </li>

</li>
        </ul>
    </div>
    </body>
    </html>
""", 'html.parser')
ul_tag = soup.ul
soup.li.extract()

print(ul_tag)
print("----------------------------")
print(soup)


# [print(element_xpath_location(element)) for element in soup.find_all()]


class TextItem:
    def __init__(self, text, section_type, text_type, location, ui_hidden=False, coodinate=None):
        self.text = text
        self.section_type = section_type
        self.text_type = text_type
        self.location = location
        self.ui_hidden = ui_hidden
        self.coodinate = coodinate
    
    def __str__(self):
        return super().__str__()


items = []
items.append(TextItem('dd/mm/yyyy', 'DATE', 'short', '/html/body'))
items.append(TextItem('12:00', 'TIME', 'short', '/html/body'))
items.append(TextItem('$100', 'CURRENCY', 'currency', '/html/body'))

for item in items:
    item.ui_hidden, item.coodinate = True, '{"width": 100, "height": 100, "x": 0, "y": 0}'


for item in items:
    print(item.ui_hidden, item.coodinate)