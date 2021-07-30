const createRequest = async (url, header) => {
    try {
      const res = await fetch(url, header);
      const json = await res.json();
      console.log(json); //debug
    } catch (error) {
      console.log(error); //debug
    }
};

const getAllBoxes = () => {
    createRequest("/api/v1/boxes", {
        method: "GET",
        headers: {
          'Content-Type': 'application/json;charset=utf-8'
        }
    })
}

const getBoxById = () => {
    createRequest("/api/v1/boxes/1", {
        method: "GET",
        headers: {
          'Content-Type': 'application/json;charset=utf-8'
        }
    })
}

const createBox = () => {
    createRequest("/api/v1/boxes", {
        method: "POST",
        headers: {
          'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(
          {id:0, barcode: 1000000000001, title: 'Из JavaScript', documents: [
            {id:0, barcode: 9000000000000, title:'Test ManyToOne'},
          ]}
          )
    })
}

const updateBox = () => {
    createRequest("/api/v1/boxes", {
        method: "PUT",
        headers: {
          'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({id:1, barcode: 1000033300001, title: 'Из JavaScript New', documents: []})
    })
}

const createDocument = () => {
  createRequest("/api/v1/documents", {
      method: "POST",
      headers: {
        'Content-Type': 'application/json;charset=utf-8'
      },
      body: JSON.stringify({boxId:1, document: {id:0, barcode: 7000000000000, title:'Add document'}})
  })
}

