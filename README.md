## Validation service

### Some examples of calling the service

```
Successful validation call:

curl http://localhost:8080/items/validate -d '{"siteId":0,"categoryId":261283,"title":"oem armrest for honda accord 2008-2009","condition":"NEW","price":0.0,"quantity":0,"imageUrls":null,"itemSpecifics":{"type":"armrest","manufacturerPartNumber":"honda-123"},"description":null}' -H "Content-Type: application/json" -s | jq
{
  "siteId": 0,
  "categoryId": 261283,
  "title": "oem armrest for honda accord 2008-2009",
  "condition": "NEW",
  "price": 0,
  "quantity": 0,
  "imageUrls": null,
  "itemSpecifics": {
    "type": "Armrest",
    "manufacturerPartNumber": "Honda-123"
  },
  "description": null
}

Error due to requirement for non-empty Manufacturer Part Number for new items:

curl http://localhost:8080/items/validate -d '{"siteId":0,"categoryId":261283,"title":"oem armrest for honda accord 2008-2009","condition":"NEW","price":0.0,"quantity":0,"imageUrls":null,"itemSpecifics":{"type":"armrest","manufacturerPartNumber":""},"description":null}' -H "Content-Type: application/json" -s | jq
{
  "errors": [
    {
      "property": "",
      "message": "Manufacturer Part Number is null for a new item"
    }
  ]
}

Successful validation for a used item with empty Manufacturer Part Number:

curl http://localhost:8080/items/validate -d '{"siteId":0,"categoryId":261283,"title":"oem armrest for honda accord 2008-2009","condition":"USED","price":0.0,"quantity":0,"imageUrls":null,"itemSpecifics":{"type":"armrest","manufacturerPartNumber":""},"description":null}' -H "Content-Type: application/json" -s | jq
{
  "siteId": 0,
  "categoryId": 261283,
  "title": "oem armrest for honda accord 2008-2009",
  "condition": "USED",
  "price": 0,
  "quantity": 0,
  "imageUrls": null,
  "itemSpecifics": {
    "type": "Armrest",
    "manufacturerPartNumber": ""
  },
  "description": null
}

Multiple errors:

curl http://localhost:8080/items/validate -d '{"siteId":0,"categoryId":261283,"title":"","condition":"NEW","price":0.0,"quantity":0,"imageUrls":null,"itemSpecifics":{"type":"armrest","manufacturerPartNumber":""},"description":null}' -H "Content-Type: application/json" -s | jq
{
  "errors": [
    {
      "property": "title",
      "message": "must not be blank"
    },
    {
      "property": "",
      "message": "Manufacturer Part Number is null for a new item"
    }
  ]
}

```