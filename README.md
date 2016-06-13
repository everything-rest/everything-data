# everything-data

## What is
Everything-data is where everything.rest data is submitted to.
**Everything.rest** is a open API containing data and algorithms that come handy while developing your server and
client side applications.
You can use it freely, simply submit your request for an API key.

## We need your help
Everything.rest is a collaborative project that it's not going anywhere without your help.
Contribute by forking this repository and committing more data! You can contribute by:

* submitting new lists
* fixing previously committed lists
* submitting new algorithms

## How to contribute
Fork this repository and commit data using the following conventions:

* select or create a first level: **category**. The name should be be broad, such as *world*, *nature* etc. Names
should be singular and have no spaces or special characters in it
* select or create a second level: **type**. The name should represent what the collection contains, such as *country*,
*bird* etc. Names should be singular and have no spaces or special characters in it
* if the type already exists, a config file should be already present. If it's new, here's how it works:

```
{
    "collection": "collection name",
    "type": "type name",
    "id_field": "the name of the field that will be used as an ID"
}
```


Collection and type should be the same of the containing directories

* create a subdirectory named **data**. This is where the data goes in form of JSON files. The files should be named
after the date they got created in the YYMMDD.json format. The contained JSON should be an array of items. If you're
contributing to an existing type, the format should be the same. If you do not succeed in coverting your date to an
existing format, don't worry, submit it and we will do it for you as long as the data is reaonsably convertible.

* if you're **submitting scripts**, you have two options. If you're submitting general purpose data that is somehow
executable, submit it where you think it belongs, otherwise the **code** category is the place. Every runnable item
must contain the `"runnable":true` attribute a *run* object that will contain what's needed, as in:

```
"run": {
      "parameters": [
        {
          "name": "input",
          "type": "String"
        }
      ]
    }
```

Where the parameters are the input parameters fetched in the query string.

* create a *scripts* subdirectory where you're going to place your **groovy** scripts. The file name must match the
**id** field value.

* finally create a **pull request** for review