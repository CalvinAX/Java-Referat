
export default defineEventHandler(async (event) => {

    const body = await readBody(event)
    console.log(body);

    // try {
    //     const response = await fetch(`http://localhost:8080/ticket/update`, {
    //         method: 'POST',
    //         headers: {
    //             'Content-Type': 'application/json'
    //         },
    //         body: JSON.stringify(data)
    //     });

    //     if (!response.ok) {
    //         throw new Error('no available data');
    //     }

    //     return response
    // } catch (error) {
    //     console.error('Error during fetch:', error);
    // }

})