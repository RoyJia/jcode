import boto3

s3 = boto3.resource('s3')

bucket='c3po-i18n-test'
key='c3po_formatter/www.expedia.ca_4_en_CA/599/FLP.jpg'

print(s3.meta.client.generate_presigned_url('get_object', ExpiresIn=60000, Params={'Bucket': bucket, 'Key': key}))