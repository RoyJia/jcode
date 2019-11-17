import os
import json

from operator import itemgetter, attrgetter, methodcaller


json_data = os.path.abspath(os.path.join(os.path.dirname(__file__), "resources/data.json"))
with open(json_data) as json_file:
    data = json.load(json_file)
    
    job_summaries = data['job_summaries']
    job_summaries_without_url = list(map(lambda x: x.pop('url') and x, job_summaries))

    locales = sorted(set(map(lambda x: x['locale'], job_summaries)))

    locale_order = dict()
    for i, x in enumerate(locales):
        locale_order[x] = i

    print(locale_order)

    lob_order = {
        'homepage': 0,
        'Search Wizard': 1,
        'hotel': 2,
        'package': 3,
        'flight': 4
    }

    page_name_order = {
        'Homepage': 0,
        'HP_WIZ_FL': 1,
        'HP_WIZ_HTL': 2,
        'HP_WIZ_PKG': 3,
        'HP_WIZ_CAR': 4,
        'HP_WIZ_CRU': 5,
        'HP_WIZ_LX': 6,
        'HP_WIZ_VR': 7,
        'HLP': 8,
        'HSR': 9,
        'HIS': 10,
        'PWA_HSR': 11,
        'PWA_HIS': 12,
        'CKO': 13,
        'PLP': 14,
        'PKG_HSR': 15,
        'PKG_HIS': 16,
        'PKG_FSR_DEP': 17,
        'PKG_FSR_RTN': 18,
        'PKG_UDP': 19,
        'PKG_CKO': 20,
        'FLP': 21,
        'FSR_ONEWAY': 22,
        'FSR_DEP': 23,
        'FSR_RTN': 24,
        'FIS_ROUNDTRIP': 25,
        'FLT_CKO': 26,
    }

    job_summaries_without_url.sort(key=lambda x: (x['locale'], page_name_order[x['page_name']]))
    # result = sorted(job_summaries_without_url, key=itemgetter('locale', 'page_name'))

    [print(job_summary) for job_summary in job_summaries_without_url]
