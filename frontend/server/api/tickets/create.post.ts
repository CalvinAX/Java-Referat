
export default defineEventHandler(async (event) => {
    console.log('inside server submit');
    const body = await readBody(event)
    console.log(body);
    
    try {
        const response = await fetch(`http://localhost:8080/ticket`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(body)
        });

        if (!response.ok) {
            throw new Error('no available data');
        }

        return response
    } catch (error) {
        console.error('Error during fetch:', error);
    }

})